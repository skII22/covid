package Covid.Base;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
        private long total;
        private String pageNum;
        private String pageSize;
        private Integer pages;
        private List records;

        public Page getPage(Page obj,List<T> response) {
                Page<T> pages = new Page();
                pages.setPageNum(String.valueOf(obj.getPageNum()));
                pages.setPages(obj.getPages());
                pages.setPageSize(String.valueOf(obj.getPageSize()));
                pages.setTotal(obj.getTotal());
                pages.setRecords(response);
                return pages;
        }
}
