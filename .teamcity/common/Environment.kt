package commons

import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext

fun getEnvironment(): String = DslContext.getParameter(ContextParams.Environment)

fun isEsx(): Boolean = getEnvironment() == Environments.esx
fun isDevel(): Boolean = getEnvironment() == Environments.devel
fun isStaging(): Boolean = getEnvironment() == Environments.staging
fun isProduction(): Boolean = getEnvironment() == Environments.production

fun connectorsSshKeyName(): String {
    when(getEnvironment()) {
        Environments.esx -> return SshKeys.Connectors.esx
        Environments.devel -> return SshKeys.Connectors.devel
        Environments.staging -> return SshKeys.Connectors.staging
        Environments.production -> return SshKeys.Connectors.production
    }
    return "InvalidKey"
}

fun applianceSshKeyName(): String {
    when(getEnvironment()) {
        Environments.esx -> return SshKeys.Appliance.esx
        Environments.devel -> return SshKeys.Appliance.devel
        Environments.staging -> return SshKeys.Appliance.staging
        Environments.production -> return SshKeys.Appliance.production
    }
    return "InvalidKey"
}