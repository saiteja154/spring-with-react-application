
create database if  not exists `spring-with-react-demo-schema` ;

use `spring-with-react-demo-schema`;

create table `user` ( `id` int not null auto_increment, 
`name` varchar(65)  default null, 
`username` varchar(65)  default null , 
`email` varchar(65) default null,
primary key(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;