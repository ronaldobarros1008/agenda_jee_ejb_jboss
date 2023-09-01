package br.com.rsb.crud.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Ronaldo Barros
 *
 */

@Singleton
@Startup
@DataSourceDefinition(
		name = "java:jboss/datasources/MySQLDS", // Escolha um nome apropriado para o Data Source
		className = "com.mysql.cj.jdbc.MysqlDataSource", // Classe do driver MySQL
		url = "jdbc:mysql://localhost:3306/testjboss?useTimezone=true&serverTimezone=UTC", // URL do banco de dados MySQL
		user = "root", // Nome de usuário do MySQL
		password = "Qwe15rty@" // Senha do MySQL
)

/*//Para testes apenas
@DataSourceDefinition(
		name = "java:jboss/datasources/CrudAngularDS", 
	    className = "org.h2.jdbcx.JdbcDataSource", 
	    url = "jdbc:h2:mem:test"
	)
*/

public class DBConfig {

}
