package com.ccfraser.muirwik.components.list

import com.ccfraser.muirwik.components.button.MButtonBaseProps
import com.ccfraser.muirwik.components.createStyled
import csstype.ClassName
import react.ComponentType
import react.RBuilder
import styled.StyledHandler


@JsModule("@material-ui/core/ListItemSecondaryAction")
private external val listItemSecondaryActionModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val listItemSecondaryActionComponentType: ComponentType<MButtonBaseProps> = listItemSecondaryActionModule.default

fun RBuilder.mListItemSecondaryAction(
    className: ClassName? = null,
    handler: StyledHandler<MButtonBaseProps>? = null
) {
    createStyled(listItemSecondaryActionComponentType, className, handler)
}
