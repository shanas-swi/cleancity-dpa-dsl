package _Self

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DPACleanCityProject : Project({
    name = "DPA - CleanCity"

    buildType(DPACleanCityProject_Build)

    subProject(DpaInstallers)
    subProject(DpaToolsAndLibraries)
})

object DPACleanCityProject_Build : BuildType({
    name = "Build-Sample"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
})


object DpaInstallers : Project({
    name = "DPA Installers"

    vcsRoot(DpaGitConnector)

    buildType(DpaInstallers_Build)
})

object DpaInstallers_Build : BuildType({
    name = "Build"

    vcs {
        root(DpaGitConnector)
    }

    triggers {
        vcs {
        }
    }
})

object DpaGitConnector : GitVcsRoot({
    name = "DPA (github) master"
    pollInterval = 120
    url = "git@github.com:solarwinds/dpa.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    checkoutPolicy = AgentCheckoutPolicy.USE_MIRRORS
    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
        uploadedKey = "TeamCity Access to GitHub"
    }
})


object DpaToolsAndLibraries : Project({
    name = "DPA Tools and Libraries"

    vcsRoot(DpaGitTestRuntimeConnector)

    buildType(DpaToolsAndLibraries_Build)
})

object DpaToolsAndLibraries_Build : BuildType({
    name = "Build"

    vcs {
        root(DpaGitTestRuntimeConnector)
    }

    triggers {
        vcs {
        }
    }
})

object DpaGitTestRuntimeConnector : GitVcsRoot({
    name = "DPA Test Runtime (github) master"
    url = "https://github.com/solarwinds/dpa-test-runtime.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    checkoutPolicy = AgentCheckoutPolicy.USE_MIRRORS
    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
        uploadedKey = "TeamCity Access to GitHub"
    }
})