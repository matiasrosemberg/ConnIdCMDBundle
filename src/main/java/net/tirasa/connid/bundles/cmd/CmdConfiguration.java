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
package net.tirasa.connid.bundles.cmd;

import org.identityconnectors.common.StringUtil;
import org.identityconnectors.framework.common.exceptions.ConfigurationException;
import org.identityconnectors.framework.spi.AbstractConfiguration;
import org.identityconnectors.framework.spi.ConfigurationProperty;

public class CmdConfiguration extends AbstractConfiguration {

    public static final String OBJECT_CLASS = "OBJECT_CLASS";

    private String createCmdPath = "";

    private String updateCmdPath = "";

    private String searchCmdPath = "";

    private String deleteCmdPath = "";

    private String testCmdPath = "";

    @ConfigurationProperty(displayMessageKey = "cmd.createCmdPath.display",
            helpMessageKey = "cmd.createCmdPath.help", order = 1)
    public String getCreateCmdPath() {
        return createCmdPath;
    }

    public void setCreateCmdPath(String createCmdPath) {
        this.createCmdPath = createCmdPath;
    }

    @ConfigurationProperty(displayMessageKey = "cmd.updateCmdPath.display",
            helpMessageKey = "cmd.updateCmdPath.help", order = 2)
    public String getUpdateCmdPath() {
        return updateCmdPath;
    }

    public void setUpdateCmdPath(String updateCmdPath) {
        this.updateCmdPath = updateCmdPath;
    }

    @ConfigurationProperty(displayMessageKey = "cmd.searchCmdPath.display",
            helpMessageKey = "cmd.updateCmdPath.help", order = 3)
    public String getSearchCmdPath() {
        return searchCmdPath;
    }

    public void setSearchCmdPath(String searchCmdPath) {
        this.searchCmdPath = searchCmdPath;
    }

    @ConfigurationProperty(displayMessageKey = "cmd.deleteCmdPath.display",
            helpMessageKey = "cmd.deleteCmdPath.help", order = 4)
    public String getDeleteCmdPath() {
        return deleteCmdPath;
    }

    public void setDeleteCmdPath(String deleteCmdPath) {
        this.deleteCmdPath = deleteCmdPath;
    }

    @ConfigurationProperty(displayMessageKey = "cmd.testCmdPath.display",
            helpMessageKey = "cmd.testCmdPath.help", order = 5)
    public String getTestCmdPath() {
        return testCmdPath;
    }

    public void setTestCmdPath(String testCmdPath) {
        this.testCmdPath = testCmdPath;
    }

    @Override
    public void validate() {
        if (StringUtil.isBlank(createCmdPath)) {
            throw new ConfigurationException("Create cmd path must not be blank!");
        }
        if (StringUtil.isBlank(updateCmdPath)) {
            throw new ConfigurationException("Update cmd path must not be blank!");
        }
        if (StringUtil.isBlank(searchCmdPath)) {
            throw new ConfigurationException("Search cmd path must not be blank!");
        }
        if (StringUtil.isBlank(deleteCmdPath)) {
            throw new ConfigurationException("Delete cmd path must not be blank!");
        }
    }

}
