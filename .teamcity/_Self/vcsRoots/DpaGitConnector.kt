package _Self.vcsRoots

import commons.connectorsSshKeyName
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

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
