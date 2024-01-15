<template>
  <el-card
    shadow="never"
    v-loading="loading"
    class="m16"
    style="min-height: 70vh"
  >
    <div class="mb16 flex_center">
      <div class="flex_auto flex">
        <el-input
          class="w200px mr16"
          v-model="searchForm.hzmc"
          placeholder="患者名称"
          @blur="search"
        ></el-input>
        <el-input
          class="w200px mr16"
          v-model="searchForm.lrys"
          placeholder="录入医生"
          @blur="search"
        ></el-input>
        <el-date-picker
          v-model="searchForm.date"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions"
        >
        </el-date-picker>
        <el-button
          class="mr16 ml16"
          type="primary"
          round
          icon="el-icon-search"
          @click="search"
          >查询</el-button
        >
        <router-link to="/detail" custom>
          <el-button type="primary" round icon="el-icon-edit-outline"
            >新建</el-button
          >
        </router-link>
      </div>
      <div class="flex_none tr">
        <el-button
          round
          type="success"
          icon="el-icon-sold-out"
          @click="onExport"
          >Excel导出</el-button
        >
      </div>
    </div>
    <el-table :data="tableData" style="width: 100%" @row-dblclick="handleDetail">
      <el-table-column prop="hzmc" label="患者名称" width="180">
      </el-table-column>
      <el-table-column prop="hzxb" label="患者性别" width="180">
      </el-table-column>
      <el-table-column prop="tjrq" label="体检日期"> </el-table-column>
      <el-table-column prop="lrys" label="录入医生"> </el-table-column>
      <el-table-column prop="zdytjbh" label="自定义体检编号"> </el-table-column>
      <el-table-column prop="bz" label="备注"> </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <!-- <router-link :to="{ path: '/detail', query: { id: scope.row.id + '' }}"  custom> -->
          <el-button
            class="mr8"
            type="text"
            size="small"
            @click="handleDetail(scope.row)"
            >编辑</el-button
          >
          <!-- </router-link> -->
          <el-popconfirm
            title="确定删除吗？"
            @confirm="handleDelete(scope.row)"
          >
            <el-button slot="reference" type="text">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="tr mt16">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNo"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>
    </div>
  </el-card>
</template>

<script>
import { getBodyCheckList, deleteBodyCheck, excelExport } from "@/http/list";
import moment from "moment";

export default {
  name: "List",
  components: {},
  props: {
    props: { type: Object, default: () => {} },
  },
  data() {
    return {
      loading: false,
      tableData: [],
      searchForm: {
        hzmc: "",
        lrys: "",
        date: [],
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      pageNo: 1,
      limit: 20,
      total: 0,
    };
  },
  mounted() {
    this.setTime();
    this.getList();
  },
  methods: {
    setTime() {
      const now = new Date();
      const start = moment().subtract(29, "days").toDate();
      this.searchForm.date = [start, now];
    },
    search() {
      this.pageNo = 1;
      this.total = 1;
      this.getList();
    },
    handleCurrentChange(pageNo) {
      this.pageNo = pageNo;
      this.getList();
    },
    handleSizeChange(limit) {
      this.limit = limit;
      this.getList();
    },
    getParams() {
      const format = "YYYY-MM-DD hh:mm:ss";
      const startDate = moment(this.searchForm.date[0]).format(format);
      const endDate = moment(this.searchForm.date[1]).format(format);
      const { hzmc, lrys } = this.searchForm;
      const { pageNo, limit } = this;
      const data = { hzmc, lrys, startDate, endDate, pageNo, limit };
      return data;
    },
    async getList() {
      if (this.loading) return;
      this.loading = true;
      getBodyCheckList(this.getParams())
        .then((res) => {
          if (res.success) {
            const result = res.result || {};
            this.tableData = result.records;
            this.total = result.total * 1;
          }
        })
        .finally(() => {
          this.loading = false;
        });
    },
    async handleDelete(row) {
      this.$loading = true;
      deleteBodyCheck({ id: row.id })
        .then((res) => {
          if (res.success) {
            this.$message.success("提交成功");
            this.getList();
          }
        })
        .finally(() => {
          this.loading = false;
        });
    },
    async handleEdit(row) {
      this.$router.replace({
        url: "/list",
        query: { id: row.id },
      });
    },
    handleDetail(row) {
      this.$router.push({
        path: '/detail',
        query: { id: row.id + '' },
      })
    },
    async onExport() {
      if (this.loading) return;
      this.loading = true;
      excelExport(this.getParams())
        .then((res) => {
          if (res.success) {
            this.$message.success("导出成功");
          }
        })
        .finally(() => {
          this.loading = false;
        });
    },
  },
};
</script>

<style lang="less">
</style>
