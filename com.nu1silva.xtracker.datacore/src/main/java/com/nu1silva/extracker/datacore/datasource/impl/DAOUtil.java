/**
 *  Copyright 2017, nu1silva (nuwan@nu1silva.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.nu1silva.extracker.datacore.datasource.impl;

import com.nu1silva.extracker.datacore.datasource.Datasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOUtil {

    private static final Logger logger = LoggerFactory.getLogger(DAOUtil.class);

    private static Datasource datasource;

    public static Connection getConnection() throws SQLException {
        if (datasource != null) {
            return datasource.getConection();
        }
        throw new SQLException("Datasource is not configured properly.");
    }

}
