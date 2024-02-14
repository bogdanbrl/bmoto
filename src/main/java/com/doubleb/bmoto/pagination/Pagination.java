package com.doubleb.bmoto.pagination;

import com.doubleb.bmoto.service.filter.v2.search.SearchProductCriteria;
import org.springframework.data.domain.Sort;

public class Pagination {

    private int page;
    private int items;
    private String direction;
    private String strToSearch;
    private String sort;
    private SearchProductCriteria criteria;

    public Pagination() {
        this.page = 0;
        this.items = 26;
        this.direction = Sort.Direction.ASC.toString();
        this.strToSearch = "";
        this.sort = "name";
        this.criteria = new SearchProductCriteria();
    }

    public Pagination(int page, int items, String direction, String strToSearch, String sort, SearchProductCriteria criteria) {
        this.page = page;
        this.items = items;
        this.direction = direction;
        this.strToSearch = strToSearch;
        this.sort = sort;
        this.criteria = criteria;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if(direction.equals("DESC")){
            this.direction = Sort.Direction.valueOf(direction).toString();
        }else{
            this.direction = Sort.Direction.ASC.toString();
        }
    }

    public String getStrToSearch() {
        return strToSearch;
    }

    public void setStrToSearch(String strToSearch) {
        this.strToSearch = strToSearch;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        switch (sort){
            case "manufacturer" : this.sort = sort; break;
            case "price" : this.sort = sort; break;
            case "createdAt" : this.sort = sort; break;
            case "colours.name" : this.sort = sort; break;
            case "genders.name" : this.sort = sort; break;
            case "sizes.name" : this.sort = sort; break;
            case "category.name" : this.sort = sort; break;
            case "inventory.quantity" : this.sort = sort; break;
            case "discount.discountPercent" : this.sort = sort; break;
            default: this.sort = "name"; break;
        }
    }

    public SearchProductCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchProductCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", items=" + items +
                ", direction='" + direction + '\'' +
                ", strToSearch='" + strToSearch + '\'' +
                ", sort='" + sort + '\'' +
                ", criteria=" + criteria +
                '}';
    }
}
