package DpaInstallers

import DpaInstallers.buildTypes.DpaBuildConfiguration
import DpaInstallers.vcsRoots.DpaGitConnector

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object DpaInstallersProject : Project({
    name = "DPA Installers"

    vcsRoot(DpaGitConnector)

    buildType(DpaBuildConfiguration)
})