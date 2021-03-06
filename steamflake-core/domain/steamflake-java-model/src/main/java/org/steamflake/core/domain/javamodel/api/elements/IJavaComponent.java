//
// (C) Copyright 2015 Martin E. Nordberg III
// Apache 2.0 License
//

package org.steamflake.core.domain.javamodel.api.elements;

import org.steamflake.core.domain.base.model.api.elements.ESteamflakeAbstractness;
import org.steamflake.core.domain.base.model.api.elements.ESteamflakeAccessibility;
import org.steamflake.core.infrastructure.utilities.collections.IIndexable;

import java.util.Optional;

/**
 * An interface, enum, or class.
 */
public interface IJavaComponent
    extends IJavaAnnotatableModelElement, IJavaTyped {

    /**
     * Creates a method within this component.
     *
     * @param name        the name of the method.
     * @param description a description of the method.
     * @param returnType  the return type of the method.
     *
     * @return the newly created method.
     */
    @SuppressWarnings( "BooleanParameter" )
    default IJavaMethod addMethod(
        String name,
        String description,
        IJavaType returnType
    ) {
        return this.addMethod(
            name,
            Optional.of( description ),
            ESteamflakeAccessibility.PUBLIC,
            ESteamflakeAbstractness.CONCRETE,
            false,
            false,
            returnType
        );
    }

    /**
     * Creates a method within this component.
     *
     * @param name          the name of the method.
     * @param description   a description of the method.
     * @param accessibility the accessibility of the method.
     * @param abstractness  whether the new method is abstract.
     * @param isStatic      whether the new method is static.
     * @param isFinal       whether the new method is final.
     * @param returnType    the return type of the method.
     *
     * @return the newly created method.
     */
    @SuppressWarnings( "BooleanParameter" )
    IJavaMethod addMethod(
        String name,
        Optional<String> description,
        ESteamflakeAccessibility accessibility,
        ESteamflakeAbstractness abstractness,
        boolean isStatic,
        boolean isFinal,
        IJavaType returnType
    );

    /** @return the interfaces implemented by this component. */
    IIndexable<IJavaImplementedInterface> getImplementedInterfaces();

    /** @return the methods within this component. */
    IIndexable<IJavaMethod> getMethods();

    /** @return the parent of this package. */
    @Override
    IJavaPackage getParent();

    /** @return whether this component is external (i.e. referenced but not generated by this model). */
    boolean isExternal();

    /**
     * Constructs a generic Java type with one type argument.
     *
     * @param typeArg1 the type argument for the new type.
     *
     * @return the newly created type.
     */
    IJavaType makeGenericType( IJavaComponent typeArg1 );

}
