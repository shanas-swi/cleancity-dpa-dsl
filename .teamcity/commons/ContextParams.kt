package commons

object ContextParams {
    const val Environment = "Environment"
}

object Environments {
    const val esx = "ESX"
    const val devel = "Devel"
    const val staging = "trebuchet-stage-us-east-1"
    const val production = "cleancity-prod-us-east-1"
}

object SshKeys {
    private object Common {
        const val devel = "TeamCity Access to GitHub"
        const val staging = "swi-teamcity-github.key"
        const val production = "swi-teamcity-github.key"
    }
    object Connectors {
        const val esx = "sem-teamcity-dev--to--sem-connectors"
        const val devel = Common.devel
        const val staging = Common.staging
        const val production = Common.production
    }
    object Appliance {
        const val esx = "sem-teamcity-dev--to--sem-mo-appliance"
        const val devel = Common.devel
        const val staging = Common.staging
        const val production = Common.production
    }
}
