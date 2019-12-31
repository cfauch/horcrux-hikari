# horcrux-hikari
Plugin to use HikariCP with horcrux

## Installation

If you use Maven add this dependency:

```
    <dependency>
      <groupId>com.fauch.code</groupId>
      <artifactId>horcrux-hikari</artifactId>
      <version>1.0.0</version>
    </dependency>
```

after having add the dependency to `horcrux`and the dependency to the suitable JDBC driver.

## Usage
Create a new `java.util.Properties` object with the properties you want to use to configure Hikari.

```
    final Properties prop = new Properties();
    prop.setProperty("jdbcUrl", "jdbc:postgresql:hx");
    prop.setProperty("username", "totoro");
    prop.setProperty("password", "2what4?");
    prop.setProperty("autoCommit", "false");
    prop.setProperty("poolName", "database-connection-pool"); 
```
Now, you can call `DataBase.init("pool").build(prop)` to build a new `DataBase` object that uses 
the HikariCP database connection pool.

Example:

```
    final Properties prop = new Properties();
    prop.setProperty("jdbcUrl", "jdbc:postgresql:hx");
    prop.setProperty("username", "totoro");
    prop.setProperty("password", "2what4?");
    prop.setProperty("autoCommit", "false");
    prop.setProperty("poolName", "database-connection-pool");
    final Path scripts = Paths.get(Main.class.getResource("/database").toURI());
    try(DataBase db = DataBase.init("pool")
                        .withScripts(scripts)
                        .versionTable("horcrux_versions")
                        .build(prop)) {
        db.open(ECreateOption.SCHEMA, ECreateOption.UPGRADE);
        System.out.println("version:" + db.getCurrentVersion());
    }
```