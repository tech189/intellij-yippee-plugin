package yippee.listeners

import com.intellij.execution.testframework.TestsUIUtil
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import yippee.util.*

class UnitTests(private val project: Project, private val listener: Listener): Restartable {
    override fun start(disposable: Disposable) {
        project.messageBus.connect(disposable).subscribe(Notifications.TOPIC, object: Notifications {
            override fun notify(notification: Notification) {
                if (notification.groupId == TestsUIUtil.NOTIFICATION_GROUP.displayId) {
                    val testsFailed = notification.type == NotificationType.ERROR
                    if (testsFailed) listener.onUnitTestFailed()
                    else {
                      listener.onUnitTestSucceeded()
                      show("Yippee!!! <img src=\"https://c.tenor.com/mJU99ZjtlQsAAAAM/tbh-creature.gif\"/>")
                    }
                }
            }
        })
    }

    interface Listener {
        fun onUnitTestSucceeded()
        fun onUnitTestFailed()
    }
}
