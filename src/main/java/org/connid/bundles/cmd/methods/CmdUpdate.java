/*
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2011 Tirasa. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://IdentityConnectors.dev.java.net/legal/license.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing the Covered Code, include this
 * CDDL Header Notice in each file
 * and include the License file at identityconnectors/legal/license.txt.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */
package org.connid.bundles.cmd.methods;

import java.util.Iterator;
import java.util.Set;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.Uid;

public class CmdUpdate extends CmdExec {

    private String scriptPath = null;

    private Uid uid;

    private Set<Attribute> attrs;

    public CmdUpdate(final String path, final Uid uid, final Set<Attribute> attrs) {
        scriptPath = path;
        this.uid = uid;
        this.attrs = attrs;
    }

    public void execUpdateCmd() {
        exec(scriptPath, createEnv());
    }

    private String[] createEnv() {
        String[] arrayAttributes = new String[attrs.size() + 1];
        final Iterator attributes = attrs.iterator();
        int index = 0;
        while (attributes.hasNext()) {
            Attribute attribute = (Attribute) attributes.next();
            arrayAttributes[index] = attribute.getName() + "=" + attribute.getValue().get(0);
            index++;
        }
        arrayAttributes[attrs.size()] = "UIIIIIIIIIIIIID=" + uid;
        return arrayAttributes;
    }
}
