package com.gxu.tbvp.Respond;

import com.gxu.tbvp.domain.NewRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewRouteRespond  extends JpaRepository<NewRoute,Integer> {
    public List<NewRoute> findById(Integer id);

    public List<NewRoute> findByDays(Integer days);

    public List<NewRoute> findByRoute(String route);

    public List<NewRoute> findByDate(Integer date);

    public List<NewRoute> findByCity(String city);

    public List<NewRoute> findByCompany(String company);

    @Query(value = "select * from new_route where price >= ?1 and price <= ?2", nativeQuery = true)
    public List<NewRoute> findBetweenPrice(Integer p1, Integer p2);

    //模糊查询
    public List<NewRoute> findByTitleLike(String title);
    public List<NewRoute> findByRouteLike(String title);

    //一日游多条件查询
    @Query(value = "select * from new_route  where title like %?1% and days=1", nativeQuery = true)
    public List<NewRoute> findTitleAndDays(String r1);

    //多条件查询 字段可为空
    @Query(value = "select * from new_route where if(?1 !='0',route=?1,1=1) and if(?2 !='',days=?2,1=1)" +
            "and if(?3 !='',date=?3,1=1) and if(?4 !='0',city=?4,1=1) and if(?5 !='0',company=?5,1=1) ",nativeQuery = true)
    public List<NewRoute> find(String route,Integer days,Integer date,String city,String company);
}
