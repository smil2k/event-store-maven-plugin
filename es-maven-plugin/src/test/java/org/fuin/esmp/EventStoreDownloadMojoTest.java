/**
 * Copyright (C) 2015 Michael Schnell. All rights reserved. 
 * <http://www.fuin.org/>
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library. If not, see <http://www.gnu.org/licenses/>.
 */
package org.fuin.esmp;

import static org.fest.assertions.Assertions.assertThat;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;

/**
 * Test for {@link EventStoreDownloadMojo}.
 */
public class EventStoreDownloadMojoTest {

    // CHECKSTYLE:OFF Test

    @Test
    public void testExecute() throws MojoExecutionException {

        // PREPARE
        final EventStoreDownloadMojo testee = new EventStoreDownloadMojo();
        testee.setProxyIgnored(false);
        FileUtils.deleteQuietly(testee.getEventStoreDir());
        if (testee.getEventStoreDir().exists()) {
            throw new IllegalStateException("Couldn't delete: "
                    + testee.getEventStoreDir());
        }
        FileUtils.deleteQuietly(testee.getDownloadFile());
        if (testee.getDownloadFile().exists()) {
            throw new IllegalStateException("Couldn't delete: "
                    + testee.getDownloadFile());
        }

        // TEST
        testee.execute();

        // VERIFY
        assertThat(testee.getDownloadFile()).exists();
        assertThat(testee.getEventStoreDir()).exists();

    }

    // CHECKSTYLE:ON

}
