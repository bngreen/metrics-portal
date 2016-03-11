/*
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
package models.ebean;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Data model for Version Specifications (for Evergreen).
 *
 * @author Matthew Hayter (mhayter at groupon dot com)
 */
@Entity
@Table(name = "version_specifications", schema = "portal")
public class VersionSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdatedTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    /*
    Note that these precedence values are intended to be sequential; each new row inserted with some precedence will force the update
    of this property for every row with greater precedence. This is a known limitation of this design, and may need to fixed if
    the number of version_specification rows becomes prohibitively large.
    */
    @Column(name = "precedence")
    private Long precedence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_set_id")
    private VersionSet versionSet;
}
