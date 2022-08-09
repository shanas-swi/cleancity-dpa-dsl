package DpaInstallers.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DpaGitConnector : GitVcsRoot({
    name = "DPA (github) master"
    url = "https://github.com/solarwinds/dpa.git"
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