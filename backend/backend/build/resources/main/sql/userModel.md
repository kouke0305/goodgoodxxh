selectuserinfo
===
```sql
select * from user 
where  id=#id# 
```

getAppOpenIdEmployee
===
```sql
select * from user  where app_openid=#openid#;
```

getUserByuserId
===
```sql
select * from user  where id=#userid#;
```

updateAppUserOpenId
===
```sql
update user 
set
	app_openid=#openid#
where
	phone=#phone#;
```

getAppOpenIdUser
===
```sql
select * from user where app_openid=#openid#;
```

selectUserByPhone
===
```sql
select * from user where phone=#phone#;
```