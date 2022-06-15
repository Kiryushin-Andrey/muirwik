package com.ccfraser.muirwik.components.table

import com.ccfraser.muirwik.components.createStyled
import csstype.ClassName
import react.ComponentType
import react.RBuilder
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/TableFooter")
private external val tableFooterModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val TableFooterComponentType: ComponentType<MTableFooterProps> = tableFooterModule.default

external interface MTableFooterProps : StyledProps {
    var component: String
}

fun RBuilder.mTableFooter(
    component: String = "tfoot",

    className: ClassName? = null,
    handler: StyledHandler<MTableFooterProps>? = null
) {
    createStyled(TableFooterComponentType, className, handler) {
        attrs.component = component
    }
}
