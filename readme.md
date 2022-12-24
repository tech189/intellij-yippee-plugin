![](resources/META-INF/pluginIcon.svg)
# Yippee!!!
This IntelliJ plugin plays the "yippee" sound effect every time your tests pass! 🎉

It was hacked together based on Dmitry Kandalov's [Friday Mario](https://github.com/dkandalov/friday-mario) plugin which adds sound effects to common IDE actions.

### Build
Open the project in IntelliJ IDEA and open the Gradle view after everything has indexed etc.

Under Tasks > intellij, double click buildPlugin. After it builds, it produces a zip in `build/distributions`.

You can then install this manually with Settings... > Plugins > [settings cog icon] > Install Plugin From Disk... and select the zip file from the previous step.
