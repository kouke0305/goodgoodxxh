

selectFillOrder
===
```sql
SELECT 
 @pageTag() {
    o.name,
    o.snumber,
    o.jnumber,
    o.address,
    o.phone,
    o.cid,
    o.caid,
    o.goods,
    o.sid,
    o.eid,
    o.`start`,
    o.`end`,
    o.`status`,
    o.`ostatus`,
    o.`dispatchper`,
    o.`createtime`,
    o.vmachine,
    count(d.id) as number
 @}
 FROM `oorder`o 
 left JOIN dispatching d
 ON o.snumber = d.snumber
 where o.phone = #phone# GROUP BY o.snumber
```
