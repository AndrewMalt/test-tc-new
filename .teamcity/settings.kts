import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.03"

project {

    buildType(NewTest)
    buildType(SecondBuild)
    buildType(ThirdBuild)
}

object NewTest : BuildType({
    name = "new_test"

    steps {
        script {
            name = "echo status"
            id = "simpleRunner"
            executionMode = BuildStep.ExecutionMode.ALWAYS
            scriptContent = """echo "Hello""""
        }
        script {
            name = "echo hello_world"
            id = "echo_hello_world"
            scriptContent = """echo "Hello World""""
        }
    }
})

object SecondBuild : BuildType({
    name = "second_build"

    steps {
        script {
            name = "echo hello_world_2"
            id = "echo_hello_world_2"
            scriptContent = """echo "hello_world_2""""
        }
    }
})

object ThirdBuild : BuildType({
    name = "third_build"

    steps {
        script {
            name = "echo status"
            id = "simpleRunner"
            executionMode = BuildStep.ExecutionMode.ALWAYS
            scriptContent = """echo "Hello""""
        }
        script {
            name = "echo hello_world2"
            id = "echo_hello_world2"
            scriptContent = """echo "Hello World2""""
        }
        script {
            name = "echo hello_world3"
            id = "echo_hello_world3"
            executionMode = BuildStep.ExecutionMode.ALWAYS
            scriptContent = """echo "Hello World3""""
        }
    }
})
