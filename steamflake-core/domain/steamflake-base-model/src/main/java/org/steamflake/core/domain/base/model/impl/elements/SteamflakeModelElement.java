//
// (C) Copyright 2015 Martin E. Nordberg III
// Apache 2.0 License
//

package org.steamflake.core.domain.base.model.impl.elements;

import org.steamflake.core.domain.base.model.api.elements.ISteamflakeAbstractPackage;
import org.steamflake.core.domain.base.model.api.elements.ISteamflakeContainerElement;
import org.steamflake.core.domain.base.model.api.elements.ISteamflakeModelElement;
import org.steamflake.core.domain.base.model.api.utilities.IFileOrigin;

import java.util.Optional;

/**
 * Implementation of ISteamflakeModelElement.
 */
@SuppressWarnings( { "AbstractClassWithoutAbstractMethods", "ClassReferencesSubclass" } )
public abstract class SteamflakeModelElement<
    IRootPackage extends ISteamflakeAbstractPackage<IRootPackage, IConcretePackage>,
    IConcretePackage extends ISteamflakeAbstractPackage<IRootPackage, IConcretePackage>
    >
    implements ISteamflakeModelElement<IRootPackage, IConcretePackage> {

    /**
     * Constructs a new Steamflake parentless model element.
     *
     * @param description a description of this model element.
     */
    protected SteamflakeModelElement(
        Optional<IFileOrigin> origin,
        Optional<String> description
    ) {
        super();

        this.description = description;
        this.parent = (ISteamflakeContainerElement<IRootPackage, IConcretePackage>) this;
        this.origin = origin;
    }

    /**
     * Constructs a new Steamflake model element
     *
     * @param parent      the parent of this model element.
     * @param description a description of this model element.
     */
    protected SteamflakeModelElement(
        SteamflakeContainerElement<IRootPackage, IConcretePackage> parent,
        Optional<IFileOrigin> origin,
        Optional<String> description
    ) {
        super();
        this.description = description;
        this.parent = parent;
        this.origin = origin;

        parent.onAddChild( this );
    }

    @Override
    public final Optional<String> getDescription() {
        return this.description;
    }

    @Override
    public final Optional<IFileOrigin> getOrigin() {
        return this.origin;
    }

    @Override
    public ISteamflakeContainerElement<IRootPackage, IConcretePackage> getParent() {
        return this.parent;
    }

    @Override
    public IRootPackage getRootPackage() {
        return this.parent.getRootPackage();
    }

    private final Optional<String> description;

    private final Optional<IFileOrigin> origin;

    private final ISteamflakeContainerElement<IRootPackage, IConcretePackage> parent;

}
