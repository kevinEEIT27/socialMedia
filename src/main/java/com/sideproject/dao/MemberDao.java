package com.sideproject.dao;

import com.sideproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer> {
}
