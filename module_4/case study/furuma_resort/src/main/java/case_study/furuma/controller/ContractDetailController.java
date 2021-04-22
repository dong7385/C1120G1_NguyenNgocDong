package case_study.furuma.controller;

import case_study.furuma.model.contract.AttachService;
import case_study.furuma.model.contract.ContractDetail;
import case_study.furuma.model.customer.Customer;
import case_study.furuma.serrvices.contract.AttachServiceService;
import case_study.furuma.serrvices.contract.ContractDetailService;
import case_study.furuma.serrvices.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/contract_detail"})
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    ContractService contractService;

    @GetMapping("")
    public String index(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        model.addAttribute("contractDetails", contractDetails);
        return "contract_detail/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findAll());
        model.addAttribute("contractDetails", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/save")
    public String save(ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract_detail";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findAll());
        model.addAttribute("contractDetails", contractDetailService.findById(id));
        return "contract_detail/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        contractDetailService.deleteById(id);
        return "redirect:/contract_detail";
    }
}
