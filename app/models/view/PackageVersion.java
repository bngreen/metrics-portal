/**
 * Copyright 2016 Groupon.com
 *
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
package models.view;

import com.arpnetworking.logback.annotations.Loggable;
import com.google.common.base.MoreObjects;

/**
 * View model for package-version.
 *
 * @author Matthew Hayter (mhayter at groupon dot com)
 */
@Loggable
public class PackageVersion {

    public String getPackageName() {
        return _packageName;
    }

    public void setPackageName(final String value) {
        _packageName = value;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(final String value) {
        _version = value;
    }

    public String getUri() {
        return _uri;
    }

    public void setUri(final String value) {
        _uri = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", Integer.toHexString(System.identityHashCode(this)))
                .add("class", this.getClass())
                .add("PackageName", _packageName)
                .add("Version", _version)
                .add("Uri", _uri)
                .toString();
    }

    private String _packageName;
    private String _version;
    private String _uri;
}
