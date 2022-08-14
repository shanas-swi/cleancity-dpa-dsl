package DpaToolsAndLibraries.SwdpaCustomUtil.vcsRoots

import commons.connectorsSshKeyName
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object SwdpaCustomUtilConnector : GitVcsRoot({
    name = "DPA Custom Util (github) master"
    url = "git@github.com:solarwinds/swdpa-customutil.git"
    branch = "%gitDefaultBranch%"
    branchSpec = "%gitBranchSpecification%"
    authMethod = uploadedKey {
        uploadedKey = connectorsSshKeyName()
//        uploadedKey = "TeamCity Access to GitHub"
    }
//    param("useAlternates", "true")
//    authMethod = password {
//        userName = "shanas-swi"
//        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
//    }
})