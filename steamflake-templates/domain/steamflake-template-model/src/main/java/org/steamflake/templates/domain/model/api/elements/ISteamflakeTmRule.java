//
// (C) Copyright 2015 Martin E. Nordberg III
// Apache 2.0 License
//

package org.steamflake.templates.domain.model.api.elements;

import org.steamflake.core.domain.base.model.api.elements.ESteamflakeAbstractness;
import org.steamflake.core.domain.base.model.api.elements.ESteamflakeAccessibility;
import org.steamflake.core.domain.base.model.api.elements.ISteamflakeNamedModelElement;
import org.steamflake.core.infrastructure.utilities.collections.IIndexable;
import org.steamflake.core.infrastructure.utilities.files.FileOrigin;

import java.util.Optional;

/**
 * A template rule.
 */
public interface ISteamflakeTmRule
    extends ISteamflakeNamedModelElement<ISteamflakeTmRootPackage, ISteamflakeTmPackage>,
            ISteamflakeTmDirectiveContainer {

    /**
     * Creates a parameter for this method.
     *
     * @param origin      the source file location of the new parameter.
     * @param name        the name of the parameter.
     * @param description an optional description of the parameter.
     * @param typeName    the type of the parameter.
     *
     * @return the newly created parameter.
     */
    ISteamflakeTmParameter addParameter(
        Optional<FileOrigin> origin,
        String name,
        Optional<String> description,
        String typeName
    );

    /**
     * @return whether this is an abstract or concrete rule.
     */
    ESteamflakeAbstractness getAbstractness();

    /**
     * @return the accessibility of this rule.
     */
    ESteamflakeAccessibility getAccessibility();

    /**
     * @return the parameters within this method.
     */
    IIndexable<ISteamflakeTmParameter> getParameters();

    @Override
    ISteamflakeTmTemplate getParent();

}
