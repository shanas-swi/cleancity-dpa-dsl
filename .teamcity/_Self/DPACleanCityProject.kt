package _Self

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DPACleanCityProject : Project({

    buildType(Build)

    subProject(DpaInstallers)
    subProject(DpaToolsAndLibraries)
})

object Build : BuildType({
    name = "Build-Sample-2"

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
    name = "Build-Sample2-2"

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
    url = "https://github.com/solarwinds/dpa.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
        uploadedKey = "TeamCity Access to GitHub"
    }
    param("useAlternates", "true")
//    authMethod = password {
//        userName = "shanas-swi"
//        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
//    }
})


object DpaToolsAndLibraries : Project({
    name = "DPA Tools and Libraries"

    vcsRoot(DpaTestRuntimeGitConnector)

    buildType(DpaToolsAndLibraries_Build)
})

object DpaToolsAndLibraries_Build : BuildType({
    name = "Build-Sample3-2"

    vcs {
        root(DpaTestRuntimeGitConnector)
    }

    triggers {
        vcs {
        }
    }
})

object DpaTestRuntimeGitConnector : GitVcsRoot({
    name = "DPA Test Runtime (github) master"
    url = "https://github.com/solarwinds/dpa-test-runtime.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
        uploadedKey = "TeamCity Access to GitHub"
    }
    param("useAlternates", "true")
//    authMethod = password {
//        userName = "shanas-swi"
//        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
//    }
})
