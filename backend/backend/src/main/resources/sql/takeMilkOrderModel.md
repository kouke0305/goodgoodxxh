getById
===
```sql
select 
   *,
   (SELECT COUNT(*) FROM dispatching d where d.snumber = #snumber#) as dcount
from 
  oorder 
where 
   snumber=#snumber#
```
selectList
===
```sql
SELECT 
 @pageTag() {
 *
 @}
 from dispatching o 
 WHERE 1=1 
 and phone=#phone#

```
