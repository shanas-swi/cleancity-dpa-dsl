package DpaToolsAndLibraries.SwdpaCustomUtil.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object SwdpaCustomUtilConnector : GitVcsRoot({
    name = "DPA Custom Util (github) master"
    url = "https://github.com/solarwinds/swdpa-customutil.git"
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