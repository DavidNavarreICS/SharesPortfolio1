/*
 * Portfolio, open source software.
 * Copyright (C) 2014-2019 SonarSource
 * mailto:navarre@irit.fr
 *
 * Portfolio is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Portfolio is distributed in the hope that it will be useless,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * This abstract class is used as a support to handle Shares and their prices.
 *
 * @author David Navarre
 */
public abstract class AbstractShare {

    /**
     * Name of the share.
     */
    private String name;

    /**
     * Message used for exceptions when trying to set the name of the share with
     * null or an empty string.
     */
    private static final String ILLEGAL_NAME_ERROR
            = "The share name must be defined.";

    /**
     * Build a Share providing it with a name.
     *
     * @param aName the name of the share. This name cannot be null or empty.
     */
    public AbstractShare(final String aName) {
        if (Objects.isNull(aName) || aName.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_NAME_ERROR);
        }
        this.name = aName;
    }

    /**
     * Provide read access to the name of the AbstractShare.<br>
     * This method is not designed to be overriden.
     *
     * @return the name of the AbstractShare
     */
    public final String getName() {
        return name;
    }

    /**
     * This method provides the price of the share for a given day.
     *
     * @param day the day for which the price is required.
     * @return the price of the share for a given day.
     */
    public abstract float getPrice(Day day);

    /**
     * {@inheritDoc}<br> To ensure a coherent distribution within Hash
     * structures, the hashcode is computed in the same way for any children of
     * this class.<br>
     * As there is no constraint on the name definition,<br>
     * the hashcode of any objects of this class is the one of its name.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(this.name);
    }

    /**
     * {@inheritDoc}<br>
     * To encourage unicity of the name, two shares are equals is their name is
     * the same.<br>This method thus cannot be overriden. *
     */
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractShare)) {
            return false;
        }
        final AbstractShare other = (AbstractShare) obj;
        return Objects.equals(this.name, other.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return this.getName();
    }
}
