package com.ccfraser.muirwik.components

import kotlinx.js.jso
import react.ComponentType
import react.Props
import react.RBuilder


@JsModule("@material-ui/core/CssBaseline")
private external val cssBaselineModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val cssBaselineComponentType: ComponentType<Props> = cssBaselineModule.default

fun RBuilder.mCssBaseline() {
    child(cssBaselineComponentType, jso()) {}
}

