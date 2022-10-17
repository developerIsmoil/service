package com.terminal.service.impl;

import com.terminal.entity.Users;
import com.terminal.exceptions.RequiredException;
import com.terminal.model.filter.UserFilterRequest;
import com.terminal.model.request.UserRequest;
import com.terminal.repository.BranchRepasitory;
import com.terminal.repository.OrganizationRepository;
import com.terminal.repository.UsersRepository;
import com.terminal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BranchRepasitory branchRepasitory;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Page<Users> findByName(UserFilterRequest request) {
        return usersRepository.findByName(request.getName(), PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Users save(UserRequest request) {

        Users user = usersRepository.findByUsername(request.getUserName());

        Users users = request.getId() == null
                ? new Users()
                : usersRepository.findById(request.getId())
                .orElse(new Users(request.getId()));

        if (!users.equals(user) && user != null)
            throw new RequiredException("Username band");
        users.setName(request.getName());
        users.setUsername(request.getUserName());
        users.setBranch(request.getBranchId() == null ? null : branchRepasitory.findById(request.getBranchId()).orElse(null));
        users.setOrganization(request.getOrganizationId() == null ? null : organizationRepository.findById(request.getOrganizationId()).orElse(null));

        return usersRepository.save(users);
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            throw new RequiredException("ID ni kiriting");
        usersRepository.deleteById(id);
    }
}
