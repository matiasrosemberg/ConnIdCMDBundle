/**
 * Copyright (C) 2011 ConnId (connid-dev@googlegroups.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.connid.bundles.cmd.realenvironment;

import org.connid.bundles.cmd.CmdConnector;
import org.connid.bundles.cmd.utilities.AttributesTestValue;
import org.connid.bundles.cmd.utilities.SharedTestMethods;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.junit.Before;
import org.junit.Test;

public class CmdCreateTest extends SharedTestMethods {

    private CmdConnector connector;

    private Name name;

    private AttributesTestValue attrs = null;

    @Before
    public final void initTest() {
        attrs = new AttributesTestValue();
        connector = new CmdConnector();
        connector.init(createConfiguration());
        name = new Name(attrs.getUsername());
    }

    @Test
    public final void testConnection() {
        connector.init(createConfiguration());
        connector.create(ObjectClass.ACCOUNT, createSetOfAttributes(name, attrs.getPassword(), true), null);
        connector.dispose();
    }
}