package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object Tests : BuildType({
    name = "tests"

    vcs {
        root(TeamCityCucumberPlugin)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = """echo "Hello""""
        }
    }
})
