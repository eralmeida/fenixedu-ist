/**
 * Copyright © 2013 Instituto Superior Técnico
 *
 * This file is part of FenixEdu IST GIAF Contracts.
 *
 * FenixEdu IST GIAF Contracts is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu IST GIAF Contracts is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu IST GIAF Contracts.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ist.fenixedu.contracts.persistenceTierOracle;

public class GiafDbConnector extends DbConnector {

    private static GiafDbConnector instance = null;

    public static GiafDbConnector getInstance() {
        if (instance == null) {
            synchronized (GiafDbConnector.class) {
                if (instance == null) {
                    instance = new GiafDbConnector();
                }
            }
        }
        return instance;
    }

    @Override
    protected String dbProtocol() {
        return "jdbc:oracle:thin:@";
    }

    @Override
    protected String dbAlias() {
        return FenixIstGiafContractsConfiguration.getConfiguration().dbGiafAlias();
    }

    @Override
    protected String dbUser() {
        return FenixIstGiafContractsConfiguration.getConfiguration().dbGiafUser();
    }

    @Override
    protected String dbPass() {
        return FenixIstGiafContractsConfiguration.getConfiguration().dbGiafPass();
    }

}
