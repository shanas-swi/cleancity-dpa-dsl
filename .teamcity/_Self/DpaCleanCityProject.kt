package _Self

import DpaInstallers.DpaInstallersProject
import DpaToolsAndLibraries.DpaToolsAndLibrariesProject
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DpaCleanCityProject : Project({

    subProject(DpaInstallersProject)
    subProject(DpaToolsAndLibrariesProject)
})


object DpaTestRuntimeGitConnector : GitVcsRoot({
    name = "DPA Test Runtime (github) master"
    url = "https://github.com/solarwinds/dpa-test-runtime.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
//    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
//        uploadedKey = "TeamCity Access to GitHub"
//    }
//    param("useAlternates", "true")
    authMethod = password {
        userName = "shanas-swi"
        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
    }
})
