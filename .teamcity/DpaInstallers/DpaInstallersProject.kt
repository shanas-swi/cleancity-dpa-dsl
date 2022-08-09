package DpaInstallers

import DpaInstallers.buildTypes.DpaBuildConfiguration
import DpaInstallers.vcsRoots.DpaGitConnector

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object DpaInstallersProject : Project({
    name = "DPA Installers"

    vcsRoot(DpaGitConnector)

    buildType(DpaBuildConfiguration)
})