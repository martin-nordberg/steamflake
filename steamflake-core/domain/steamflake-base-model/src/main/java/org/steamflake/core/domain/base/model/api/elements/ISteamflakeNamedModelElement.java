//
// (C) Copyright 2015 Martin E. Nordberg III
// Apache 2.0 License
//

package org.steamflake.core.domain.base.model.api.elements;

/**
 * A generic model element with a name.
 */
public interface ISteamflakeNamedModelElement<
    IRootPackage extends ISteamflakeAbstractPackage<IRootPackage, IConcretePackage>,
    IConcretePackage extends ISteamflakeAbstractPackage<IRootPackage, IConcretePackage>
    >
    extends ISteamflakeModelElement<IRootPackage, IConcretePackage> {

    /**
     * @return The name of this element.
     */
    String getName();

}
