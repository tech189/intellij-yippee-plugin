package yippee.sounds

import com.intellij.openapi.util.io.StreamUtil
import java.io.IOException

class Sounds private constructor(load: (Config) -> Sound) {
    val oneUp: Sound

    private class Config(val filePath: String, val isBackgroundMusic: Boolean = false)

    companion object {
        fun create(actionSoundsEnabled: Boolean, backgroundMusicEnabled: Boolean): Sounds =
            Sounds {
                val enabled = it.isBackgroundMusic && backgroundMusicEnabled || !it.isBackgroundMusic && actionSoundsEnabled
                if (enabled) Sound(loadBytes(it.filePath), it.filePath)
                else SilentSound(loadBytes(it.filePath), it.filePath, SilentSound.Listener.none)
            }

        fun createSilent(listener: SilentSound.Listener) =
            Sounds { SilentSound(loadBytes(it.filePath), it.filePath, listener) }

        private fun loadBytes(fileName: String) =
            try {
                val inputStream = Sounds::class.java.getResourceAsStream(fileName) ?: error("Cannot find $fileName")
                StreamUtil.loadFromStream(inputStream)
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
    }

    init {
        oneUp = load(Config("/yippee/sounds/yippee.au"))
    }
}
