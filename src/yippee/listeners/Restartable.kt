package yippee.listeners

import com.intellij.openapi.Disposable

interface Restartable {
    fun start(disposable: Disposable)
}
