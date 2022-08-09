package DpaInstallers

import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object DpaInstallersProject : Project({
    id("DpaInstallers")
    name = "DPA Installers"
    description = "Database Performance Analyzer (formerly Confio Ignite)"


})
