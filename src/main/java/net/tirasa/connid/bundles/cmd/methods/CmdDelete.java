/* 
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2011 ConnId. All rights reserved.
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License.
 * 
 * You can obtain a copy of the License at
 * http://opensource.org/licenses/cddl1.php
 * See the License for the specific language governing permissions and limitations
 * under the License.
 * 
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://opensource.org/licenses/cddl1.php.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */
package net.tirasa.connid.bundles.cmd.methods;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.Uid;

public class CmdDelete extends CmdExec {

    private static final Log LOG = Log.getLog(CmdDelete.class);

    private String scriptPath = null;

    private Uid uid;

    public CmdDelete(final ObjectClass oc, final String path, final Uid uid) {
        super(oc);

        this.uid = uid;
        scriptPath = path;
    }

    public void execDeleteCmd() {
        waitFor(exec(scriptPath, createEnv()));
    }

    private String[] createEnv() {
        return new String[] {"OBJECT_CLASS=" + oc.getObjectClassValue(), uid.getName() + "=" + uid.getUidValue()};
    }
}