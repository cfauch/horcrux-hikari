/*
 * Copyright 2019 Claire Fauch
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.code.fauch.horcrux.hikari;

import java.util.Properties;

import javax.sql.DataSource;

import com.code.fauch.horcrux.spi.IHorcrux;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * horcrux implementations that provides a JDBC connection pool based on HikariCP.
 * 
 * @author c.fauch
 *
 */
public final class HikariHorcrux implements IHorcrux {

    /**
     * The implemented horcrux type.
     */
    private static final String TYPE = "pool";
    
    /**
     * Creates and returns Hikari data source 
     */
    @Override
    public DataSource newDataSource(final Properties properties) {
        return new HikariDataSource(new HikariConfig(properties));
    }

    /**
     * Close the Hikari data source.
     */
    @Override
    public void close(DataSource ds) {
        ((HikariDataSource)ds).close();
    }

    /**
     * It's a "pool" implementation.
     */
    @Override
    public boolean accept(String type) {
        return TYPE.equals(type);
    }

}
