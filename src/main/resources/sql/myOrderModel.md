selectOrderByPhone
===
```sql
SELECT 
 @pageTag() {
    o.* 
 @}
 from oorder o 
 WHERE 1=1 
 and phone=#phone#
 ORDER BY createtime DESC ,if(isnull(eid),0,1) DESC
```
