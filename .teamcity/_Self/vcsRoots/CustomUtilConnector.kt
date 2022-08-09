package _Self.vcsRoots

import commons.connectorsSshKeyName
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object CustomUtilConnector : GitVcsRoot({
    name = "dpa-customutil-connector (master)"
    pollInterval = 120
    url = "git@github.com:solarwinds/swdpa-customutil.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    checkoutPolicy = AgentCheckoutPolicy.USE_MIRRORS
    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
        uploadedKey = "TeamCity Access to GitHub"
    }
})
