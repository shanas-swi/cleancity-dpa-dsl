package DpaToolsAndLibraries

import DpaToolsAndLibraries.SwdpaCustomUtil.SwdpaCustomUtilProject
import jetbrains.buildServer.configs.kotlin.v2019_2.*

object DpaToolsAndLibrariesProject : Project({
    name = "DPA Tools And Libraries"

    subProject(SwdpaCustomUtilProject)
})