JPA

@OneToOne
@OneToMany (List, Set, Map, SortedSet, SortedMap) 1st 2 most common
@ManyToOne - inverse of above
@ManyToMany - join table

Unidirectional only 1 side is mapped
Bidirectional recommended for object graph navigation

Owning
The owning side holds the FK in db
    One to one where fk is specified
    OneToMany and ManyToOne is many side
    MappedBy define owning fields

Fetch Type
Lazy - at time of request
Eager - all loaded upfront
JPA 2.1 Fetch type defaults
Default:
- OneToMany - lazy
- ManyToOne - eager
- ManyToMany - lazy
- OneToOne - eager

JPA cascade types - changes from parent to child
types:
   - Persist, saved ops will cascade to related entities
   - Merge, related entities merged when owning entity is merged
   - Refresh, related entities are refreshed when the owning entity is refreshed
        go and get latest data
   - Remove - removes all related when parent deleted
   - Detach - detach related if manual detach occurs *
   - All - applies all the above cascade options
By default no operations are cascaded
* watch out error if detach get error use with lazy type

Embeddable Types
common set of properties, e.g. for address

Inheritance
- mappedSuperclass - entities inherit from super class - db table not created for superclass
- single table - hibernate default - one table used for all superclasses (adds add'n columns in db table)
- joined table - base class and subclasses have their own tables, join
- table per class - each subclass has its own class

Create and update timestamps
callbacks JPA @PrePersist and @PreUpdate via JPA lifecycle callbacks
(Hibernate specific @CreationTimeStamp and @UpdateTimestamp)