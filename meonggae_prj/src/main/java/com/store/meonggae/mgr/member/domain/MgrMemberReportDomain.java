package com.store.meonggae.mgr.member.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MgrMemberReportDomain {
	private String title, contents, nickSell, processStatusCode;
	private Date inputDate, processDate;
}
